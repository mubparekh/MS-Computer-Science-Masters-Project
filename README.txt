# Master's Final Project

Project Topic: 
"Comparing Test Case Redundancies in Manually Versus Automatically Created Test Suites"

Research Abstract: 
Software testing is an important phase in software development where test suite generation is an expensive process in terms of time and analysis. Tests generation should be fast, efficient and effective in terms of quality and time. Writing such test cases is challenging and require more human effort. Thus automated test generation techniques have been developed to ease the load of software developers but its effectiveness and efficiency is very little studied. Automated test generation is fast as compared to manual test creation but its quality should also be compared in terms of time and effectiveness. As test suites are run frequently during regression testing, redundancies in test cases within test suite can negatively impact the overall execution time.In this research we compare the quality of manually to automatically generated test suites on the basis of redundancy in test cases present using 10 real world applications. Our results show that on average, automated tool as compared to manual produced 13% less full test case redundancies, 75% more partial test redundancies and 26% more overall test suite redundancies. 
//For more information refer my research paper

Java Algorithm:
Developed an algorithm to find and compare test case redundancies between test cases in manually and automatically generated test suites.
Algorithm Input: Statement coverage matrix of a test suite, generated using Gzoltar command line library
Algorithm Outputs:
- Finds test case redundancy in each set of test suite (manual and automated)
- Finds % redundancy correlation between test cases in a test suite (<25%, 26%-50%, 51%-81%, 81%-99% and 100% full redundant test cases)
- Minimizes test suites by removing found test case redundancies for a test suite
- Calculates coverage of a test suite before and after removing test case redundancies

Experimental Subjects:
10 real world Java open source SF110 applications- Jnfe, Jsecurity, Xisemele, Jdbacl, Netweaver, Dieberse, Jni-inchi, Lagoon, Lavalamp, Schemaspy


