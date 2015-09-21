# enigma_metal_campaign
ENIGMA Metal Metabolism Campaign generates various types of biological data. This repository contains KBase data models, data uploaders/downloaders, etc to enable modeling of a collaborative research of several ENIMGA Metal Campaign teams in the Kbase environment.

# Input file format
All uploaders accept tab-separated text files with txt or tsv extension.
File must contain two sections, data and metadata.

Data section consists of a table which leftmost column contains rows identifiers R1, R2, R3... and top row contains column identifiers C1, C2, C3.... Top left cell must contain DATA word. All other cells should contain decimal numbers. All values that cannot be converted to decimal numbers will be changed to 0.00 during upload.
Example:

|DATA |C1 |C2 |C3|
|---|---|---|---|
|R1  |0.00  |0.00 |0.00|
|R2  |0.11  |0.22 |0.44|
|R3  |0.22  |0.33 |0.66|

Metadata section contains a table with five columns.
The first raw of metadata table must contain only "METADATA Type  Name  Unit  Value".
The first (leftmost) column of metadata should contain either identifiers of columns and rows of data or "T".
"T" marks metadata that applies to the whole data series.
The second column indicates a subject of metadata, the third column indicates a property of the subject.
Last two columns of metadata section contain value and measurement unit of the property. Unit is optional.

For example, growth data series for the data shown above contain the following metadata:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|T |Base media  |Name ||LB|
|C1 |Nickel |Concentration |mM |0.00
|C2 |Nickel |Concentration |mM |1.00
|C3 |Nickel |Concentration |mM |10.00
|R1 |TimeSeries |Time |hours |0
|R2 |TimeSeries |Time |hours |1
|R3 |TimeSeries |Time |hours |3

