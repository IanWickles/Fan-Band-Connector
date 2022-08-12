<template>
  <band-details v-bind:bandId="parseInt($route.params.bandId)" />
</template>
<!--  
// this is going to be the band(singular) profile page
//managers need a Edit/Update button
//optional delete button -- if we get other stuff done first
// contains band detail component 
// follow/unfollow button -- no notification if unfollowed
//need to add photo gallery ability
//managers need to be able to select all followers to send messages to 
-->

<script>
import BandDetails from "../components/BandDetails.vue";
export default {
  components: { BandDetails },
};
</script>

<style>
template {
  margin: 10px;
}
</style>
