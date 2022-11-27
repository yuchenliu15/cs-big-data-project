import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.HashSet;
import java.util.Arrays;

public class CountLinesMapper 
    extends Mapper<LongWritable, Text, Text, IntWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
      String line = value.toString();
      String line_arr[] = line.split(",");
      if(!line_arr[1].equals("planning_area")){
        String area = line_arr[1];
        context.write(new Text("Number of records for " + area),new IntWritable(1));
      }

  }
}
