package saavn.trend.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import saavn.trend.util.TextPair;
import saavn.trend.util.Utilities;

public class SaavnMapper extends Mapper<LongWritable, Text, TextPair, IntWritable> {

	private final IntWritable one = new IntWritable(1);

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String[] st = value.toString().split(",");
		if (st.length == 5 && Utilities.isNotNullOrEmpty(st[0]) && Utilities.isNotNullOrEmpty(st[4]) && !"(null)".equals(st[0])) {

				TextPair _tp = new TextPair(st[0].trim(), st[4].trim());
				context.write(_tp, one);				
			
		}
	}
}