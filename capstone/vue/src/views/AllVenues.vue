<template>
  <div>
    <section>
      <h1>Venues</h1>
      <venue-list />
      <!-- we need to move this to the venue details -->
      <iframe width="600" height="450" style="border:0" loading="lazy" allowfullscreen src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJ9cCHcw2mIIYRV7dOHIoKO4Q&key=AIzaSyBRq0tBrXJcI2Tff8JxVYGmR58CimOPI7o"></iframe>

    </section>
  
  </div>
</template>
<!--  
//need to be tied to venue list 
//clicking on venue takes you to its page 

-->
<script>
import VenueList from "../components/VenueList.vue";
export default {
  components: { VenueList },
};
</script>

<style>
section {
  height: 500px;
  margin: 50px;
}
h1 {
  font-weight: bold;
  margin: 10px;
}
</style>
