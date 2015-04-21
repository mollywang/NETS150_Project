#Project team members: 
Molly Wang, Juilan Gutierrez , Aryaman Vir

###Project category:
- Implementation
- Empirical analysis

###Project description:
- Validate (or not) the hypothesis: "College tuition is negatively correlated with the likelihood for students to tweet about race-related issues."

###Methodology: 
- Measure awareness and involvement through mentions of said social issue on Twitter using word match and hashtags.
- Deduce trends by tracking data

###Test case: 
Pick four universities accross the country in different "tuition ranges" divisions.

- low (i.e Delta State University	[$6,187](http://www.usnews.com/education/best-colleges/the-short-list-college/articles/2014/09/30/10-public-colleges-with-the-cheapest-out-of-state-tuition-and-fees
))
- mid, (TBD)
- high, (TBD)
- very high (i.e Sarah Lawrence College [$65,480](http://www.businessinsider.com/the-10-most-expensive-colleges-in-america-2014-11))

Determine a small set of hashtags depict a late media-resounding, race-related event in the past months.
We will consider the police shooting of [Tony Robinson Jr](http://www.nbcnews.com/news/us-news/madison-wisconsin-cop-shoots-suspect-during-confrontation-police-n319136) earlier this semester.



###Project breakdown:
Our project will implement social networks by means of Twitter as well as Document Search through parsing Tweet data.
We will examinine Twitter data surrounding the above test case and cross reference it with different demographics student body that we will gather as a group.

####Group:
- Collect demographic statistics from 4 large public state universities in each tuition segment.

####Molly:
- Identifying a small set of hashtags related to the even described above. (i.e #BlackLivesMatter)
- Finding the data source dumps of tweets related as a CSV or JSON (preferrably). 
- writeup a brief description of the event's background and how were the data dumps obtained
- Conduct analysis as a group

####Aryaman:
- Identifying tuition ranges for the four defined categories (low, mid, high, very high)
- Picking one school for each segment
- Defining each school's geo border in Twitters compatible format.
- Conduct analysis as a group

####Julián:
- Find the set of keywords that describe the involvment to the cause in negative or positive way.
- Parse Twitter data from date/time surrounding that event to find level of awareness (maybe we could use the cosine similarity against difference queries) 
- Writeup on how the keywords were curated.
- Conduct analysis as a group
