<% include '/WEB-INF/includes/header.gtpl' %>
<%
def github = "https://github.com/lantoli/yosethegame-googleappengine-java-practice/blob/master/src"
def ghServiceSource = "${github}/main/webapp/WEB-INF/groovy"
def ghServiceTest = "${github}/functionalTest/groovy/service"
def ghUiSource = "${github}/main/webapp/WEB-INF/pages"
def ghUiTest = "${github}/functionalTest/groovy/page"
def ghAlgoSource = "${github}/main/groovy"
def ghAlgoTest = "${github}/test/groovy"
%>
<ul class="inline-list">
<li class="inline-list portfolio">Ping</li>
<li class="inline-list service"><a href="/ping"id="ping-challenge-link" target="_blank" class="service">Service</a></li>
<li class="inline-list"><a href="${ghServiceSource}/PingService.groovy" target="_blank">Source</a></li>
<li class="inline-list"><a href="${ghServiceTest}/PingServiceSpec.groovy" target="_blank">Specs</a></li>
</ul>
<ul class="inline-list">
<li class="inline-list portfolio">Prime Factors</li>
<li class="inline-list service"><a href="/primeFactors/ui" target="_blank" class="service" id="prime-factors-decomposition-link">UI</a></li>
<li class="inline-list"><a href="${ghUiSource}/primeFactors.gtpl" target="_blank">Source</a></li>
<li class="inline-list"><a href="${ghUiTest}/PrimeFactorsPageSpec.groovy" target="_blank">Specs</a></li>
</ul>
<ul class="inline-list">
<li class="inline-list portfolio invisible">Prime Factors</li>
<li class="inline-list service"><a href="/primeFactors?number=4" target="_blank" class="service">Service</a></li>
<li class="inline-list"><a href="${ghServiceSource}/PrimeFactorsService.groovy" target="_blank">Source</a></li>
<li class="inline-list"><a href="${ghServiceTest}/PrimeFactorsServiceSpec.groovy" target="_blank">Specs</a></li>
</ul>
<ul class="inline-list">
<li class="inline-list portfolio invisible">Prime Factors</li>
<li class="inline-list service">Algorithm</li>
<li class="inline-list"><a href="${ghAlgoSource}/Decomposition.groovy" target="_blank">Source</a></li>
<li class="inline-list"><a href="${ghAlgoTest}/DecompositionSpec.groovy" target="_blank">Specs</a></li>
</ul>
<br>
Some technologies used in this practice:
<ul>
<li><a href="https://developers.google.com/appengine" target="_blank">Google App Engine</a></li>
<li><a href="http://groovy.codehaus.org" target="_blank">Groovy</a></li>
<li><a href="http://gaelyk.appspot.com" target="_blank">Gaelyk</a></li>
<li><a href="http://www.gradle.org" target="_blank">Gradle</a></li>
<li><a href="https://code.google.com/p/spock" target="_blank">Spock</a></li>
<li><a href="http://www.gebish.org" target="_blank">Geb</a></li>
<li><a href="http://phantomjs.org" target="_blank">Phantomjs</a></li>
<li><a href="https://github.com" target="_blank">Github</a></li>
</ul>
<% include '/WEB-INF/includes/footer.gtpl' %>

