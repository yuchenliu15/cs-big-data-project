
import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.*;

public class CleanMapperEthnicity extends Mapper<LongWritable, Text, Text, Text> {
    private static final int MISSING = 9999;
    @Override    
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String line_arr[] = line.split(",");
        if(line_arr[1].equals("english")){
            context.write(new Text("planning_area,year"),new Text("chinese, malays, indian"));
        } else {
            String area_year = line_arr[39] + "," + line_arr[40];
            int zeroes = 0;
            String lineToWrite[] = new String[3];
            int counter = 0;
            for(int i = 36; i <= 38; i++){
                if(line_arr[i].equals("0")){
                    zeroes++;
                }
                lineToWrite[counter] = line_arr[i];
                counter ++;
            }
            if(zeroes != 3){
                String x = String.join(",", lineToWrite);
                context.write(new Text(area_year),new Text(x));
            }

        }

        } 
    } 
