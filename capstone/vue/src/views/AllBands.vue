<template>
  <div>
    <h1 class="name">Bands</h1>
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
    <button><router-link v-bind:to="{ name: 'new-band' }">Create a New Band</router-link></button>
    </div>
    <div class="adminhub" v-if="isAdmin">
      <button>Manage genres</button>
      <button>Manage bands</button>
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
  computed: {
    isAdmin() {
      return this.$store.state.user.authorities.find(authority=>authority.name=="ROLE_ADMIN")!=undefined;
    }
  }
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
