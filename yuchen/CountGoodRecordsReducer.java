import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CountGoodRecordsReducer
    extends Reducer<Text, IntWritable, Text, IntWritable> {
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values, Context context)
      throws IOException, InterruptedException {
    
    int total = 0;
    for (IntWritable value : values) {
      total += value.get();
    }
    String word = key.toString();
    String capital = word.substring(0, 1).toUpperCase();
    capital +=  word.substring(1);
    context.write(new Text(capital), new IntWritable(total));
  }
}


