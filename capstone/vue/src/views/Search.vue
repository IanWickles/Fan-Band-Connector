<template>
  <div>
    <band-list />
    <venue-list />
    <div></div>
  </div>
</template>
<!--  
*need to be tied to band list and venue list 
*as well as create new band option at top of band search 
*needs to have (search) user input on both band-venue 
*clicking on band-venue takes you to its page 
   -->
<script>
import VenueList from "../components/VenueList.vue";
import BandList from "../components/BandList.vue";
export default {
  components: { VenueList, BandList },
};
</script>

<style></style>
