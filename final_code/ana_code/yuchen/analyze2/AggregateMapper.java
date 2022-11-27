import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.HashSet;
import java.util.Arrays;

public class AggregateMapper 
    extends Mapper<LongWritable, Text, Text, DoubleWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    String line = value.toString();
    String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
     
    String location = tokens[0];
    String perPrice = tokens[4].trim();
    try{
        context.write(new Text(location), new DoubleWritable(Double.parseDouble(perPrice)));
    } catch(Exception e) {
        throw e; 
    }
  }
}
