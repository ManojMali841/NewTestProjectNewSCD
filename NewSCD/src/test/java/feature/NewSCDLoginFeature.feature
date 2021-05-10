Feature: NewSCD functional test





@Smoketest1
Scenario: verify title of new SCD login page

Given launch new SCD url
When  check title of login page
Then  verify actual title with expected title of New SCD login page


@Smoketest2
Scenario: verify new SCD login functionalty with Negative Login Credentials

Given user click on New SCD username text field
When  user enters invalid username and password
And   click on sign in button to login into New SCD
And   user refresh the login page
Then  user enters valid username and password
And   user click on sign in button to login into New SCD



@Smoketest3
Scenario: Create New User 

Given click on expand button 
When  click on user management 
Then  click on create new user
And   enter details in create user form and save
Then  click on logout button

@Smoketest4
Scenario: Newly created user login along with answering  security questions & new password setting

Given login with newly created user login credentials 
And   Answer All Security questions 
When  enter new password and confirm password
And   click on submit button
Then  redirect to New SCD Login Window

@Smoketest5
Scenario: After saving new password for newly created user relogin with new credentials

Given relogin with new credentials of newly created user
When  click on sign in button
Then  user is on New SCD homepage 

@Smoketest6
Scenario: From Admin login Edit a user details

Given login New SCD with Admin User
And   click on NewSCD user management
When  Search for a user and click on three dots against a user
And   select option edit user 
And   edit user details
And   save the edited user details
Then  check edited details are saved successfully 


@Smoketest7
Scenario: From Admin delete a user

Given login New SCD with Admin
And   click on NewSCD user mgmt
When  Search for a user and click on three dots
And   select delete user and click on OK
Then  confirm user is deleted successfully
















