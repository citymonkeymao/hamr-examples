HAMR examples
===
This is examples of HAMR.
usage:

hadoop jar example.jar xxxJob \<input path> \<output path>
#word count
The classcial example of mapreduce. [Official description](http://hadoop.apache.org/docs/current/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html)

Coresponding data: datas/wordcountdata

Format: text
#ip count
Count how many identical ip occured for each url

Coresponding data: datas/visitip

Format: ip###url
#max temprature
Find the highiest temprature of each city

Coresponding data: datas/climitdata

Format:city###year###temprature

#visit time
Calculate visit time of each sessionId.

Coresponding data: datas/visittimedatas

Format: message time###sessionId###url


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/citymonkeymao/hamr-examples/trend.png)](https://bitdeli.com/free "Bitdeli Badge")