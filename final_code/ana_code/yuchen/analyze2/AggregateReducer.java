import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AggregateReducer 
    extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
  
  @Override
  public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
      throws IOException, InterruptedException {
    Double total = 0.0;
    int n = 0;
    for(DoubleWritable value: values) {
        total += value.get();
        n++;
    }
    if(n > 0)
    context.write(key, new DoubleWritable(total/n));
  }
}


