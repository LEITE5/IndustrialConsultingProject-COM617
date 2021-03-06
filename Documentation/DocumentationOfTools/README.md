# Requirements for Industrial Consulting project:

**Requirements for Industrial Consulting project:**



|**Functional**|**Non-functional**|
| :-: | :-: |
|<p>- Create a test plan</p><p>&emsp;- Canary testing</p><p>&emsp;- Green/blue/red testing</p><p>&emsp;- Integration testing</p>|- Unit test|
|- Make a request every x time (every 5 mins not sure)||
|<p>- Store performance metrics in influxDB (metrics tbd)</p><p>&emsp;- Status (main metric)</p><p>&emsp;- Latency</p><p>&emsp;- Sample size(Bytes)</p><p>&emsp;- Ms response(Maybe)</p><p>&emsp;- Amount of Users(Our own site)</p>||
|- Visually represent stored metrics in graphics with Grafana||
|- Developing a website to display graphics from grafana.||
|- Work on API requests from grafana in order to display the graphs||
|<p>- Diagrams:</p><p>&emsp;- Use case scenarios</p><p>&emsp;- Sequence diagram</p><p>&emsp;- Architecture/Deployment Diagram</p><p>&emsp;- Robustness diagram (maybe)</p>||


Application Goal:

- Solution that continuously displays UX and availability monitoring test results on a web page.

How are we doing it

How are we evaluating it

**Task(s) allocation:**

**Leites and Aeryk:** JMeter implementations

**Afonso and Rui:** InfluxDB and Grafana

**Tebogo:** Docker


**Meetings:**

**Tue:** 12-1pm

**Thu:** 2pm - ?

notes 16/02/21 - 
docker compose to spin up container
jmeter
influxdb
grafana

rest call to push JMX to application

overall description of project:
system diagram 
project plan
open GitHub

create template for report and presentation and assign parts to team members

presentation on 02/03 with openNMS




# Use Cases IC

**Use Cases**

User Inputs custom test script into website
Several visualizations (graphs, charts, etc)
Execute periodically


**Use cases text**

User Inputs custom test script into website

|1) User builds jmeter test||
| :- | :- |
|2) User inputs custom test script into website||
||3) Website tests the file extension (.jmx) inputted by the user|
||4) Jmeter test file is executed|
||5) Saving test results to influxDB|









Several visualizations (graphs, charts, etc)//User monitoring

(display the graphs from grafana in our website)

|1) User enters monitoring page||
| :- | :- |
||2) Grafana loads the influxDB containing the test results|
||3) Grafana displays visualizations for the test results|

### Initial System Architecture Diagram
<img src="Diagram/firstDiagram.png">
