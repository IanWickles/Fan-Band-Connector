<template>
  <div>
    <div class="searchbar">
    <input
      class="input is-rounded"
      v-model="input"
      name="byBand"
      type="text"
      placeholder="Search by band"
    />
    <input
      class="input is-rounded"
      name="byGenre"
      type="text"
      placeholder="Search by genre"
    />
    <button class="big-button"><router-link v-bind:to="{ name: 'new-band' }">Create a New Band</router-link></button>
    </div>
      <band-list />
  </div>
</template>
<!--  
*need to be tied to venue list 
*as well as create new band option at top of band search 
*needs to have (search) user input on both band-venue 
*clicking on band-venue takes you to its page 
   -->
<script>
import BandList from "../components/BandList.vue";
export default {
  components: { BandList},
};
</script>

<style>
section {
  height: 500px;
  margin: 50px;
}
h1 {
  font-weight: bold;
  margin-bottom: 10px;
}
.searchbar {
  margin-left: 10vw;
  margin-right: 10vw;
}
</style>
