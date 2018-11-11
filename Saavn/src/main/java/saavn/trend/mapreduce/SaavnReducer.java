package saavn.trend.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import saavn.trend.util.TextPair;

public class SaavnReducer extends Reducer<TextPair, IntWritable, Text, IntWritable> {
	public void reduce(TextPair key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int count = 0;
		
		for (IntWritable val : values) {
			count = count + val.get();
		}
		context.write(new Text(key.toString()), new IntWritable(count));

	}
}