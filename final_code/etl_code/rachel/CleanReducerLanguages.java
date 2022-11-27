
import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CleanReducerLanguages extends Reducer <Text, Text, Text, Text>{
@Override

    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException { 
        int count = 0;
        for(Text value: values) {
            count ++;
            if(count == 1){
                String output = key + "," + value;
                context.write(new Text(output), new Text(""));
            }
        }


    }

}

