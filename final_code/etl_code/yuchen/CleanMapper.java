import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.HashSet;
import java.util.Arrays;

public class CleanMapper 
    extends Mapper<LongWritable, Text, Text, Text> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    String line = value.toString();
    String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    String town = tokens[1];
    String area = tokens[6];
    int l = tokens.length;
    String leaseRemain = tokens[l-2];
    String price = tokens[l-1];
    
    if(town.length() == 0 || area.length() == 0
            || leaseRemain.length() == 0 || price.length() == 0) {
        return;
    }
       context.write(value,new Text(String.join(",",new String[]{town,area,leaseRemain, price})));
 

  }
}
