import java.io.IOException;
 	import java.util.*;
 	import java.io.*;
 	
 	import org.apache.hadoop.fs.Path;
 	import org.apache.hadoop.conf.*;
 	import org.apache.hadoop.io.*;
	import org.apache.hadoop.mapred.*;
 	import org.apache.hadoop.util.*;
 	
 	public class color {
 	
 	   public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
 	     //private final static IntWritable one = new IntWritable(1);
 	     private Text r = new Text();
 	     private Text g = new Text();
 	     private Text b = new Text();
 	
 	     public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
 	       String line = value.toString();
 	       StringTokenizer tokenizer = new StringTokenizer(line);
 	       while (tokenizer.hasMoreTokens()) {
 	         r.set(tokenizer.nextToken());
 	         g.set(tokenizer.nextToken());
 	         b.set(tokenizer.nextToken());
 	         //String command = "python home/hduser/wc/test.py";
			//String parameter = " --image wheel.jpeg";
			//Process p = Runtime.getRuntime().exec(command);
			//BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			//String ret = in.readLine();
			//System.out.println("value is : "+ret);
			//String ret="50";
			//int val=Integer.parseInt(ret);
			Text green = new Text();
			green.set("green");
			Text w = new Text();
			w.set("white");
			
			if(Integer.parseInt(r.toString())>15 && Integer.parseInt(r.toString())<80)
			{
			if(Integer.parseInt(g.toString())>10 && Integer.parseInt(g.toString())<80)
			{
			if(Integer.parseInt(b.toString())>10 && Integer.parseInt(b.toString())<80)
			{
 	         output.collect(green, new IntWritable(1));
         	}}}
         	
         	if(Integer.parseInt(r.toString())==255 && Integer.parseInt(g.toString())==255 && Integer.parseInt(b.toString())==255)
         	{
         		output.collect(w, new IntWritable(1));
         	}
         	
 	       }
 	     }
 	   }
 	
 	   public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
 	     public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
 	       int sum = 0;
 	       while (values.hasNext()) {
 	         sum += values.next().get();
 	       }
 	       output.collect(key, new IntWritable(sum));
 	     }
 	   }
 	
 	   public static void main(String[] args) throws Exception {
 	     JobConf conf = new JobConf(color.class);
 	     conf.setJobName("color");
 	
 	     conf.setOutputKeyClass(Text.class);
 	     conf.setOutputValueClass(IntWritable.class);
 	
 	     conf.setMapperClass(Map.class);
 	     conf.setCombinerClass(Reduce.class);
 	     conf.setReducerClass(Reduce.class);
 	
 	     conf.setInputFormat(TextInputFormat.class);
 	     conf.setOutputFormat(TextOutputFormat.class);
 	
 	     FileInputFormat.setInputPaths(conf, new Path(args[0]));
 	     FileOutputFormat.setOutputPath(conf, new Path(args[1]));
 	
 	     JobClient.runJob(conf);
 	   }
 	}
