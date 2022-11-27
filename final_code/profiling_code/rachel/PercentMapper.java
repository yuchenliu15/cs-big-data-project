import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.*;

public class PercentMapper extends Mapper<LongWritable, Text, Text, Text> {
    private static final int MISSING = 9999;
    @Override
    
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String line_arr[] = line.split(",");
        if(!line_arr[0].equals("planning_area")){

            String area_year = line_arr[0] + "," + line_arr[1];
            String percentages[] = new String[line_arr.length - 2];

            double total = 0.0;
            for(int i = 2; i < line_arr.length; i ++){
                total += Double.parseDouble(line_arr[i]);
            }

            int counter = 0;
            for(int i = 2; i < line_arr.length; i ++){
                percentages[counter] = Double.toString(Double.parseDouble(line_arr[i])/total);
                counter ++;
            }

            context.write(new Text(area_year), new Text(String.join(",", percentages)));
    }

    } 
}
    