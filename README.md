<<<<<<< HEAD
# conduit
=======

1. Clone the repository https://github.com/sachinyadav4/Conduit.git
2. I wanted to implement cucumber feature file but due to release pressure in my current company
I could not invest much time. So I implemented CRUD unit test case 
   - Create a new article
   - Read above created article
   - Edit above created article
   - Delete above created article
All these test run in a sequence. I know test cases should be atomic but again due to timie limitation
     could not convert those into atomic once.
3. I have used Serenity framework's Actor screenplay pattern to implement these tests.
4. To run the test open terminal in intellij and run command "mvn clean test".
5. Test reports can be found under project folder "target\site\serenity" . You can refer to a video recording present at the root of git project where 
test run is recorded and also reports opened. 

Note: Please make sure everytime you run the test case delete the article created before,
although with each successful run article created will be deleted but in case you run tests individually please do so. 