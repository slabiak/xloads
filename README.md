>NearProps project (former xloads) is a web application which lists rooms/flats to rent with each one having calculated time of travel (by car, foot, bike or public transportation) to place selected by user (for example their work or school). Frontend is made with React and backend is done with the use of Java and Spring. This application is completely independent of external APIs like Google Maps, whole routing and geocoding, reversed geocoding and autocomplete for place search is done with the use of open source solutions like GrapHopper, OpenStreetPlanner, photon and OpenStreetMap. This project is still under heavy development and not finished yet.


### Live demo
Live demo of this app can be found [here](https://nearprops.netlify.app/)

<a href="https://github.com/slabiak/slabiak.github.io/blob/master/images/web.png?raw=true"><img src="https://github.com/slabiak/slabiak.github.io/blob/master/images/web.png?raw=true" width="600"></a>

<a href="https://github.com/slabiak/slabiak.github.io/blob/master/images/mobile.png?raw=true"><img src="https://github.com/slabiak/slabiak.github.io/blob/master/images/mobile.png?raw=true" width="300"></a>

This project consists of few different repositories. Below you can find short description and link to each of them:

1. `xloads` https://github.com/slabiak/xloads - This repo is a Spring Boot Java App. It handles business logic related with offers such as adding and fetching offers, authentication etc.
2. `xloads_ui` https://github.com/slabiak/xloads_ui - This repo is a React app. It makes calls to backend services and provides UI.
3. `xloads_rest_proxy` https://github.com/slabiak/xloads_rest_proxy - This service is a Spring Boot Java app. It is some kind of proxy between UI and routing and place search services. For geocoding and place search autocomplete `nomatim` is used. For bike, walk, car routing requests `graphopper` is used. For public transportation routing requests `OpenTripPlanner` is used.

**Architecture diagram**:

<a href="https://github.com/slabiak/slabiak.github.io/blob/master/images/xloads_arhcitecture.jpg?raw=true"><img src="https://github.com/slabiak/slabiak.github.io/blob/master/images/xloads_arhcitecture.jpg?raw=true"></a>
