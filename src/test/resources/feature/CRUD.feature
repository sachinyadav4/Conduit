Feature: CRUD operations for articles
  In order to post, read, update and delete articles
  As a user
  I want to be able to perform CRUD operation on conduit web page

  Scenario Outline: Post a new article
    Given that John is on home page
    When John creates a new article with <Title> , <Summary>, <Description>, <Tags>
    Then article should be present at home page global feed tab
    Examples:
      |Title                 |Summary                                 | Description                                       | Tags    |
      | Rose-ringed parakeet |Information about Rose-ringed parakeet  | The Indian ring-necked parakeet is not a shy bird | parakeet|