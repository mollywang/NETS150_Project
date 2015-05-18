#NETS150 Final Project

##Project team members: 
Molly Wang, Juilan Gutierrez , Aryaman Vir

###Project category:
- Implementation
- Empirical analysis

###Project goal:
- Examine and analyze public sentiment on Twitter following occurrence of a major event.


###Methodology: 
1. Collect all public tweets that are geotagged within time period of 5 days following the the event and filtering for those that contain the "Irene" query term.

Note: Twitter’s privacy setting has changed to block people from readily downloading public tweets, so we had to write custom code to scrape all tweets from within a certain time frame and then to parse all those tweets based on whether they contained our chosen keyword.

2. Assign a sentiment (1 - positive or 0 - negative) to each tweet, based on all of the words it contains

3. Aggregate tweets by the state with the closest geographic center based on longitude and latitude

- Find overall talkativeness:
Return the percentage of tweets containing a given term against all tweets in a given time span.

- Find most talkative state:
Return the state containing the most tweets containing a given term.

- Find public sentiment:
Find the cosine similarity of the body of tweets when run against two documents of positive and negative words respectively, and return the one with a higher cosine value
Return (1 - positive) or (0 - negative) depending on whether the overall public sentiment about the event was more positive or negative


###Variables:

- Tweet type: Public, Geotagged

- Time frame: Begin tweets date: 2011-08-28 19:02:28 / End tweets date: 2011-09-03 14:06:46

- Event: Hurricane Irene
- Keywords: “Irene”, “Hurricane”, “Hurricane Irene”

- Geographical bounds: 50 states of America & the District of Columbia

###Hypothesis:
We believe that states closest to the location of Hurricane Irene will be the most talkative and have a generally more negative sentiment about the event. 

These states will be:
Southeast region - Florida, South Carolina, North Carolina, Virginia.
Mid Atlantic region - Maryland, Delaware, Pennsylvania, New Jersey, New York, New England, Connecticut, Massachusetts, Vermont, Maine.

States further away from Hurricane Irene will display a more positive sentiment or have no sentiment at all.

###Task Flow:

####Molly:
- Get states coordinates and code to separate tweets into respective states by calculating Euclidean distance from origination of tweet by longitude & latitude
- Find set of negative & positive keywords
- Project write-up and analysis


####Aryaman:
- Separate negative & positive keywords
- Project write-up and analysis


####Julián:
- Scrape Twitter for relevant dataset
- Code from a JSON and get similarities from list of positive & negative keywords (use the cosine similarity against difference queries
- Writeup on how the keywords were curated.

