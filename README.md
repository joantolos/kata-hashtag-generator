# kata-hashtag-generator

Our community manager needs a software to generate a single text sentence containing all the desired hashtags. The main feature is that it has to be quick and easy to use. Just copy from the software and paste into the social media post.

# Requirements

Given a static finite list of words, we want a single string containing a random sub set of said words, separated by spaces and preceded with the character #.

Also, we want the string to start from another static finite list of words but not randomized this time.

# Acceptance criteria

Given:

- profile.1.default: programming, java
- profile.1.random: tdd, testing, framework, spring, kubernetes, microservice, cloud, aws, test, spock, junit

When I do a GET request like:

http://{host}/1/3

Where 1 is the profile ID and 3 is the number of random words desired,

Then I retrieve a single text sentence like:

    #programming #java #aws #tdd #spring

The first two words are the ones defined as default and the last three are randomly selected from the other list.
