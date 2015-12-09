# enigma_metal_campaign
ENIGMA Metal Metabolism Campaign generates various types of biological data. This repository contains KBase data models, data uploaders/downloaders, etc to enable modeling of a collaborative research of several ENIMGA Metal Campaign teams in the Kbase environment.

# An easy way to prepare input file
1. Put all your data and metadata on a single sheet in MS Excel or similar spreadsheet editor (see below what should be included).
2. Save as Tab-separated text file with .txt or .tsv extension.


# Input file format
All uploaders accept tab-separated text files with txt or tsv extension.
File must contain two sections, data and metadata.

# Data section
Data section consists of a table which leftmost column contains rows identifiers R1, R2, R3... and top row contains column identifiers C1, C2, C3.... Top left cell must contain DATA word. All other cells should contain decimal numbers. All values that cannot be converted to decimal numbers will be changed to 0.00 during upload.
Example:

|DATA |C1 |C2 |C3|
|---|---|---|---|
|R1  |0.00  |0.00 |0.00|
|R2  |0.11  |0.22 |0.44|
|R3  |0.22  |0.33 |0.66|

# Metadata section
Metadata section contains a table with five columns.
The first raw of metadata table must contain only "METADATA Type  Name  Unit  Value".
The first (leftmost) column of metadata should contain either identifiers of columns and rows in the data section or "T".
"T" marks metadata that applies to the whole data series.
The second column indicates a subject of metadata, the third column indicates a property of the subject.
Last two columns of metadata section contain measurement unit and value of the property. 

Metadata section must contain description of the data object in the Value column, with "T" in the leftmost cell, word "Description" in the Entity column. For example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|T |Description |||Pseudomonas stutzeri RCH2 in LB, Nickel |

Any metadata describing the entire experiment should be placed into metadata as key-value pairs in columns Property and Value. Experiment metadata must have "T" in the leftmost column and word "Experiment" in the Entity column. For example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|T |Experiment |Temperature ||30 C |
|T |Experiment |Medium ||LB |
|T |Experiment |Read ||Absorbance |

A data object may contain either statistical measures (average, standard deviation, standard error) or raw data. In the first case, metadata must contain an entry with "T" in the left most column, "Measurement" in the Entity column, "Values" in the Property column and "Measures" in the Value column:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|T |Measurement |Values||Measures |

In the second case, Measurement entry of metadata must have "RawValues" in the Value column:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|T |Measurement |Values||RawValues |

If data contain statistical measures, every column must have a separate entry in the metadata section with designation of a statistical measure. Such entries have a valid column identifier in the leftmost column (like C1, C2 etc.), "Measurement" in the Entity column, "ValueType" in the Property column and "Average", "SD" or "SE" in the value column. For example, C1 column contains average values, and C2 column contains standard deviations:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|C1 |Measurement |ValueType ||Average
|C2 |Measurement |ValueType ||SD


## GrowthMatrix-specific metadata

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
|...|...|...|...|...|
|C1 |Condition |Nickel |mM |0.00
|C1 |Condition |Strain | |Pseudomonas stutzeri RCH2
|C2 |Condition |Nickel |mM |1.00
|C2 |Condition |Strain | |Pseudomonas stutzeri RCH2

In this example, sample in C1 column was grown without nickel, but the column should be marked as having zero nickel if it is intended to be included into nickel-specific comparison.

Note: only those condition entries that have acceptable unit values (pM, nM, uM, mM, M, pg, ng, ug, mg, g for columns and hours, minutes, seconds for rows) are considered to have numerical values. All other cells in the Value column are considered to contain text.

## ChromatographyMatrix-specific metadata

Row metadata contain description of time points (see GrowthMatrix metadata section for details).

Column metadata describe type of measurement and type of value. Entity column must contain word "Measurement", and Property column must contain "Intensity". For Intensity property, the Unit column must contain "CPS", and the Value column should contain a name of substance/compound measured. 

Example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|R1 |TimeSeries |Time |seconds |1.001
|R2 |TimeSeries |Time |seconds |2.002
|...|...|...|...|...|
|C1 |Measurement |Intensity |CPS |Nickel
|C1 |Measurement |Intensity |CPS |Tungsten

## WellSampleMatrix-specific metadata

Row metadata describe samples, and column metadata describe measured characteristics. In case of row meatdata, the leftmost field contains row IDs, the Entity column contains "Sample", the Property column cotains either "ID" or "Well". The Value column contains Sample ID or Well ID, respectively.

Example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|R1 |Sample |ID | |GW101-7-25-12
|R1 |Sample |Well | |GW-101


If an entry in column metadata describes fraction, it must contain "Measurement" in the Entity column and "Fraction" in the Property column. Typical values are "Suspension", "Supernatant", "Pellet", but this is not a requirement. The Unit column should be empty.

If an entry in column metadata describes a substance, it must contain "Measurement" in the Entity column and "Substance" in the Property column. The Unit column must contain acceptable concentration unit (pM, nM, uM, mM, M). The Value column must contain a name of substance (any text).

Example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|C1 |Measurement |Substance |uM |Nickel
|C2 |Measurement |Substance |uM |Nickel
|C1 |Measurement |ValueType ||Average
|C2 |Measurement |ValueType ||SD

## Arbitrary metadata entries

Any object may contain additional metadata entries for table, rows or columns. Such entries can use any combination of Entity and Property names, except:

- Measurement.ValueType;

- TimeSeries.Time;

- Description.* (only one Description entry is allowed);

The Unit column of such entries must be always empty.

Example:

|METADATA|Entity|Property|Unit|Value|
|---|---|---|---|---|
|...|...|...|...|...|
|T |Experiment |Date | |05/16/2013
|C1 |Experiment |Machine Name | |Ti /  47 [#1]
|C1 |Experiment |Collision-Mode | |Yes
|C1 |Experiment |Isotope | |47


## Metadata validation on upload

In the process of upload, metadata will be validated. A list of checks that will be implemented include:

- One and only one Description entry exists in the metadata section (for all data types).

- One and only one Measurement.Values entry exists in the metadata section (for all data types).

- Measurement.Values entry contains either "Measures" or "RawValues" in the Value column (for all data types).

- If metadata section contains Measurement.Values entry with "Measures" values, one Measurements.ValueType entry is expected for every data column ID, and Value of the entry have acceptable values: Average, SD or SE (for all data types).

- One and only one TimeSeries.Time entry exists for any data row ID (for GrowthMatrix and ChromatographyMatrix).

- All TimeSeries.Time entries have acceptable values: hours, minutes or seconds (for GrowthMatrix and ChromatographyMatrix).

- All TimeSeries.Time entries have identical time units (for GrowthMatrix and ChromatographyMatrix).

- At least one Condition entry exists for any data column ID (for GrowthMatrix).

- All Condition entries with non-empty Unit field have acceptable units: pM, nM, uM, mM, M, pg, ng, ug, mg, g (for GrowthMatrix).

- All Condition entries with the same substance name have identical unit names (for GrowthMatrix).

- At least one Measurement entry exists for any data column ID (for ChromatographyMatrix and WellSampleMatrix).

- All Measurements.Intensity entries have identical unit names (for ChromatographyMatrix).

- All Measurements.Substance entries have acceptable unit names: pM, nM, uM, mM, M (for WellSampleMatrix).

- One and only one Sample.ID entry exists for any data row ID (for WellSampleMatrix).
