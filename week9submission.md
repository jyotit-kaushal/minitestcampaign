## Week 9 Submission- Equivalence Classes and Boundary Value Analysis

In this document, we will be getting started with the testing of our software that is being used to find out disparities between two csvs containing information like customer id, account number, etc.

To begin, we first define what the input for this particular software program is. The input in our context is a set of two csv files having the documented fields and ids, representing bank account information. We then take those 2 files and compare them against each other to find out the entries which don't correlate with each other.

## Defining our equivalence classes and doing up a boundry value analysis

To get our equivalence classes, we essentially want to divide all sorts of inputs (i.e. files we might recieve) to aptly test values from each to test whether our software performs as it's meant to. 

In brief, we are going to create two types of equivalence classes. First set being the classes that would serve as invalid inputs to our software and hence we would like leech them out. Secondly we will have a class of valid inputs but still might lead to complications when it comes to running our program. Once done, we then go forward with doing some analysis for finding the boundary values for each class.

Following this, we have our equivalence classes and their boundary value analysis as follows:

#### 1. Class containing input files not of .csv format
The boundary for this is a bold one where files having the .csv format are on the valid side while all those not are on the invalid side. The sample_file_1.csv and sample_file_3.csv for example is over this boundary where as our use case diagram in .png format for week 8 and sample_file_3.csv is on the other side.

#### 2. Class containing input files that are empty
The boundary for this is a bold one where files that are empty are on the valid side while all those not are on the invalid side. The sample_file_1.csv and sample_file_3.csv for example is over this boundary where as a newly exported .csv file without any values in it and sample_file_3.csv is on the other side.

#### 3. Class containing input files that have their information encoded
The boundary for this is a bold one where files encoded in the utf-8 format as expected are on the valid side while all those not are on the invalid side. The sample_file_1.csv and sample_file_3.csv for example is over this boundary where as a version of this sample_file_1.csv which has all its values hashed and sample_file_3.csv is on the other side.

#### 4. Class containing non-empty input files with the right format, and information encoded as we want
The boundary for this is not so bold and we can have all csv files with the utf-8 encoding content in it. An example for this is going to be again our sample_file_1.csv and sample_file_3.csv file which in this case is going to be withing the boundary (i.e. on the valid side).

#### 5. Class containing input files that fall into the fifth class however have a discrepancy in number of entries
csv files like sample_file_1.csv and sample_file_3.csv in this case are going to belong this class and within this boundary. However, an empty csv file like in class 2 and sample_file_3.csv are not going to be in this boundary.

#### 6. Class containing input files that fall into the fifth class however have a discrepancy in the order of their entries
csv files that have the same entries as their content however with the order differed will belong in this class and by extension this boundary. While this boundary does contain files that will be valid for our program, they wouldn't let our program produce the output that's intended since it'll just show all the entries as being exceptions which might not have been the intented purpose. Therefore, an example of sample_file_1.csv and sample_file_3.csv is going to be outside of this class whereas a reversed sample_file_1.csv and and sample_file_3.csv is going to be in it. 

#### 7. Class containing input files that fall into the fifth class and have no discrepancies in their number of entries, or their order
csv files that are the ideal desired inputs for this software program and the sample_file_1.csv and sample_file_3.csv will fit right into this class. Any other files within our projectscope will fall outside of this boundary.

Hence, we see we have 7 equivalence classes we can extract from the usecase our software wants to provide.


