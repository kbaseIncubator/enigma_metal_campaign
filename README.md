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
The first (leftmost) column of metadata should contain either identifiers of columns and rows in the data section or "T".
"T" marks metadata that applies to the whole data series.
The second column indicates a subject of metadata, the third column indicates a property of the subject.
Last two columns of metadata section contain measurement unit and value of the property. 

Metadata section must contain description of the data object in the Value column, with "T" in the leftmost cell, word "Description" in the Entity column. For example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|T |Description |||Pseudomonas stutzeri RCH2 in LB, Nickel |

Any metadata describing the entire experiment should be placed into metadata as key-value pairs in columns Property and Value. Experiment metadata must have "T" in the leftmost column and word "Experiment" in the Entity column. For example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|T |Experiment |Temperature ||30 C |
|T |Experiment |Medium ||LB |
|T |Experiment |Read ||Absorbance |

# GrowthMatrix-specific metadata

Row metadata describe time points in the following way:

- leftmost column contains row identifier (like R1, R2, ...);

- a cell in the Entity column contains reserved words "Time series";

- a cell in the Property column contains reserved word "Time";

- a cell in the Unit column contains one of three reserved words: "hours", "minutes" or "seconds";

- a cell in the Value column contains numerical value.

For example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|R1 |TimeSeries |Time |hours |0
|R2 |TimeSeries |Time |hours |1

In addition, row metadata may describe other characteristics of the time point. For such rows, Unit column will be ignored. For example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|R1 |Experiment |Temperature ||30 C

Column metadata may describe sample-specific conditions and type of values in the column. Column metadata entry musty contain a valid column identifier in the leftmost column (like C1, C2 etc.). Description of condition must contain reserved word "Condition" in the Entity column. For chemical substances/compound, metadata entry must contain name of a chemical in the Property column, unit of measurement in Unit column, and a numerical value of weight/concentration in the Value column. Acceptable values in the unit column are: pM, nM, uM, mM, M, pg, ng, ug, mg, g. For description of an organism grown in culture, cell in the Property column should contain "Strain", "Organism", "Mutant" etc., and cell in the Value column must contain name of the organism or designation of the strain. For example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|C1 |Condition |Nickel |mM |0.00
|C1 |Condition |Strain | |Pseudomonas stutzeri RCH2
|C2 |Condition |Nickel |mM |1.00
|C2 |Condition |Strain | |Pseudomonas stutzeri RCH2

In this example, sample in C1 column was grown without nickel, but the column should be marked as having zero nickel if it is intended to be included into nickel-specific comparison.

Note: only those condition entries that have acceptable unit values (pM, nM, uM, mM, M, pg, ng, ug, mg, g for columns and hours, minutes, seconds for rows) are considered to have numerical values. All other cells in the Value column are considered to contain text.

Columns may contain data from replicates, average values, standard deviation or standard error. To designate a specific type of value in the data column, make a metadata entry for this column with "Measurement" in the Entity column, "ValueType" in the Property column and "Replicate", "Average", "SD" or "SE" in the value column. For example, C1 contains average values, and C2 contains standard deviations:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|C1 |Measurement |ValueType ||Average
|C2 |Measurement |ValueType ||SD

# ChromatographyMatrix metadata

# WellSampleMAtrix metadata

