import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.HashSet;
import java.util.Arrays;

public class AnaMapper 
    extends Mapper<LongWritable, Text, Text, Text> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    String line = value.toString();
    String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
     
    String location = tokens[0];
    String area = tokens[1];
    String leaseRemain = tokens[2];
    String price = tokens[3].trim();
    try{
    double perPrice = Double.parseDouble(price) / Double.parseDouble(area);
    context.write(value,new Text(String.join(",",new String[]{location,area,leaseRemain, price, String.valueOf(perPrice)})));
    } catch(Exception e) {}
  }
}
