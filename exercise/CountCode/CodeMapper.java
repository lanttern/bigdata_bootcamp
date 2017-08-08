// This is a mapper to map counts of each event
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CodeMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	private final static IntWritable one = new IntWritable(1);

	@Override
	public void map(LongWritable offset, Text lineText, Context context)
		throws IOException, InterruptedException {
		String line = lineText.toString();
		String eventID = line.split(",")[1];
		if (eventID.toLowerCase().contains("diag")){
			context.write(new Text(eventID), one);
		}
	}
}
