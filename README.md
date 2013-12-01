location-search-server
======================

Servlet running on tomcat to serve location search requests.
Responds to: http://localhost:8080/api/v1/suggest/position/en/name/[search_parameter]
Always the same json String is returned:
{
  "results" : [ {
    "_type" : "Position",
    "_id" : 410978,
    "name" : "Potsdam, USA",
    "type" : "location",
    "geo_position" : {
        "latitude" : 44.66978,
        "longitude" : -74.98131
      }
  }, {
    "_type" : "Position",
    "_id" : 377078,
    "name" : "Potsdam, Deutschland",
    "type" : "location",
    "geo_position" : {
        "latitude" : 52.39886,
        "longitude" : 13.06566
      }   } ]
}

Just build with maven and then deploy the resulting target/api.war onto Tomcat,
then start the client (https://github.com/t-dome/location-search-client.git)
with the -l option, which causes it to use localhost.






