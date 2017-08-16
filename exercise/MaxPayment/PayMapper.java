// This is a mapper to map counts of each event
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PayMapper extends Mapper<LongWritable, Text, Text, FloatWritable>{

	@Override
	public void map(LongWritable offset, Text lineText, Context context)
		throws IOException, InterruptedException {
		String line = lineText.toString();
		String eventID = line.split(",")[1];
		String patientID = line.split(",")[0];
		FloatWritable payment = new FloatWritable(Float.parseFloat(line.split(",")[3]));
		if (eventID.toLowerCase().startsWith("payment")){
			context.write(new Text(patientID), payment);
		}
	}
}
