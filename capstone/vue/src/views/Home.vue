<template>
  <div class="home">
    <img src="musicnotes.png" class="headerimg" />
    <h1>Welcome to Louisiana Beat-Wave!</h1><br><br>
    <p class="mymessage">{{ message }}</p><br><br>
    <img src="jazzband.png"/><br>
    <button class="big-button"><router-link v-bind:to="{ name: 'bands' }">Explore Bands</router-link></button>
    <button class="big-button"><router-link v-bind:to="{ name: 'venues' }">Explore Venues</router-link></button>
    <button class="big-button"><router-link v-bind:to="{ name: 'shows' }">Explore Shows</router-link></button><br>
    <button class="big-button" v-if="loggedOut"><router-link v-bind:to="{ name: 'login' }">Login</router-link></button>
    <button class="big-button" v-if="loggedOut"><router-link v-bind:to="{ name: 'register' }"> Create an Account</router-link></button>
  </div>
</template>

<!--
home page 
-->
<script>
export default {
  name: "home",
  data() {
    return {
      message: "Louisiana Beat Wave celebrates the birthplace of Jazz - New Orleans, Louisiana - and it's diverse music scene. Users can connect with their favorite bands and discover new ones to fall in love with. Bands can connect with their followers by sending message updates."
    };
  },
  computed: {
    loggedOut() {
      return this.$store.state.token == '';
    }
  }
}
</script>
<style>
.home {
  text-align: center;
}
h1 {
  text-align: center;
  font-size: xx-large;
}
.mymessage {
  text-align: center;
  font-family: 'Indie Flower', cursive;
  font-size: larger;
}
.headerimg {
  display: block;
  margin:auto;
  margin-top: -100px;
  transform: scaleX(1.5);
}
</style>
