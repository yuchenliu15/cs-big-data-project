- Data source: Singapore Resale Flat Prices
    - Columns include: month listed, town, flat type, block, street name, storey range, floor area (sqm), flat model, lease commence date, remaining lease, resale price ($)
    - data source is attached as: resale-flat-prices-based-on-approval-date-2000-feb-2012.csv

- Goal: Use average housing price per region to create a nice visualization of wealth distribution between each region.

1) Cleaning and profiling data (hw7, Nov1)
    - Made sure each row does not have any missing columns.
    - Measured row count before and after cleaning to make sure we are cleaning the data correctly.

2) Analyze and create new column (hw 8, Nov 7)
    - Cleaned data to filter out column names. This way we can treat every row as int or double.
    - Added new calculated column (price per square meter). This is calculated from 2 other columns price and area of the apartment.

3) Extracting useful information (hw9, Nov 17)
    - Made data more concise by shrinking down to 2 columns: location and price per squae meter in Singapore housing.
    - Performed group by on location column to aggregate average price of housing in each region.



