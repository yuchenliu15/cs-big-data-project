
import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.*;

public class CleanMapperLanguages extends Mapper<LongWritable, Text, Text, Text> {
    private static final int MISSING = 9999;
    @Override    
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String line_arr[] = line.split(",");
        if(line_arr[1].equals("english")){
            context.write(new Text("planning_area,year,english,mandarin,chinese_dialects"),new Text("malay,tamil"));
        } else {
            String area_year = line_arr[39] + "," + line_arr[40];
            int zeroes = 0;
            String lineToWrite[] = new String[5];
            for(int i = 1; i <= 5; i++){
                if(line_arr[i].equals("0")){
                    zeroes++;
                }
                lineToWrite[i-1] = line_arr[i];
            }
            if(zeroes <= 4){
                String x = String.join(",", lineToWrite);
                context.write(new Text(area_year),new Text(x));
            }

        }

        } 
    } 
