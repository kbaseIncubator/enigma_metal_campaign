# enigma_metal_campaign
ENIGMA Metal Metabolism Campaign generates various types of biological data. This repository contains KBase data models, data uploaders/downloaders, etc to enable modeling of a collaborative research of several ENIMGA Metal Campaign teams in the Kbase environment.

# Input file format
All uploaders accept tab-separated text files with txt or tsv extension.
File must contain two sections, data and metadata.

Data section consists of a table which leftmost column contains rows identifiers R1, R2, R3... and top row contains column identifiers C1, C2, C3.... Top left cell must contain DATA word. All other cells should contain decimal numbers. All values that cannot be converted to decimal numbers will be changed to 0.00 during upload.
Example:

DATA  C1  C2  C3
R1  0.00  0.00  0.00
R2  0.11  0.22  0.44
R3  0.22  0.33  0.66

Metadata section conatins a table haing five columns.
The first raw of metadata table must contain only "METADATA Type  Name  Unit  Value".
The first (leftmost) column of metadata should contain either identifiers of columns and rows of data or "T".
"T" marks metadata that refersapplies to the whole data series.
The second column indicates type (category) of metadata, the third column indicates name.
Last two columns of metadata section contain unit and numerical(decimal) value. These two columns are optional

For example, growth data series for the data shown above contain the following metadata:
METADATA  Type  Name  Unit  Value
T Base media  LB
C1  Concentration CompoundX mM  0.00
C2  Concentration CompoundX mM  1.00
C3  Concentration CompoundX mM  10.00
R1  Time  Time  hours 0
R2  Time  Time  hours 1
R3  Time  Time  hours 3
