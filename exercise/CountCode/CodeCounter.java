// this is a main function to output counts for DIAG events:wq
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CodeCounter {
	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: Counter <inpput path> <output path>");
			System.exit(-1);
		}
		// create a Hadoop job and set the main class
		Job job = Job.getInstance();
		job.setJarByClass(CodeCounter.class);
		job.setJobName("Counter");
		
		// set the input and output path
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		// set mapper and reducer class
		job.setMapperClass(CodeMapper.class);
		job.setReducerClass(CodeReducer.class);

		// specify the type of the output
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		// run the job
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}

