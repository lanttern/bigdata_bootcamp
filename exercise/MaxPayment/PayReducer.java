// This is a reducer to only add up DIAG events
import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PayReducer extends Reducer<Text, FloatWritable, Text, FloatWritable>{
	@Override public void reduce(Text patientID, Iterable<FloatWritable>payments, Context context) throws IOException, InterruptedException{
		float maxPayment = 0.0f;
		for (FloatWritable payment : payments){
			if (payment.get() > maxPayment) maxPayment = payment.get();
		}
		context.write(patientID, new FloatWritable(maxPayment));
	}
}
