package saavn.trend.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import saavn.trend.mapreduce.SaavnReducer;
import saavn.trend.mapreduce.SaavnMapper;
import saavn.trend.util.TextPair;

public class SaavnDriver extends Configured implements Tool {

	public int run(String[] args) throws Exception {
		Configuration conf = getConf();

		Job job = Job.getInstance(conf);
		job.setJobName("Saavn Trending Songs");

		job.setJarByClass(SaavnDriver.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.setMapOutputKeyClass(TextPair.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setMapperClass(SaavnMapper.class);
		job.setCombinerClass(SaavnReducer.class);
		job.setReducerClass(SaavnReducer.class);		

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		try {
			return job.waitForCompletion(true) ? 0 : 1;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		int returnStatus = ToolRunner.run(new Configuration(), new SaavnDriver(), args);
		System.exit(returnStatus);
	}

}
