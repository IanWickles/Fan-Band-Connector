<template>
  <div class="home">
    <h1>Welcome to Louisiana Beat-Wave!</h1><br><br>
    <p class="mymessage">{{ message }}</p><br><br>
    <button class="big-button"><router-link v-bind:to="{ name: 'bands' }">Explore Bands</router-link></button>
    <button class="big-button"><router-link v-bind:to="{ name: 'venues' }">Explore Venues</router-link></button>
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
      message: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Eu mi bibendum neque egestas. A diam sollicitudin tempor id eu nisl nunc. Sed lectus vestibulum mattis ullamcorper velit. Sed odio morbi quis commodo. Malesuada fames ac turpis egestas integer eget. Cras ornare arcu dui vivamus. Volutpat ac tincidunt vitae semper quis lectus. Nulla facilisi morbi tempus iaculis. Sem nulla pharetra diam sit amet nisl. Purus ut faucibus pulvinar elementum integer enim. Nisl purus in mollis nunc sed id semper. Eget nulla facilisi etiam dignissim diam quis enim. Sed tempus urna et pharetra pharetra massa massa. A condimentum vitae sapien pellentesque habitant morbi tristique senectus. Habitasse platea dictumst quisque sagittis. Consectetur purus ut faucibus pulvinar.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Eu mi bibendum neque egestas. A diam sollicitudin tempor id eu nisl nunc. Sed lectus vestibulum mattis ullamcorper velit. Sed odio morbi quis commodo. Malesuada fames ac turpis egestas integer eget. Cras ornare arcu dui vivamus. Volutpat ac tincidunt vitae semper quis lectus. Nulla facilisi morbi tempus iaculis. Sem nulla pharetra diam sit amet nisl. Purus ut faucibus pulvinar elementum integer enim. Nisl purus in mollis nunc sed id semper. Eget nulla facilisi etiam dignissim diam quis enim. Sed tempus urna et pharetra pharetra massa massa. A condimentum vitae sapien pellentesque habitant morbi tristique senectus. Habitasse platea dictumst quisque sagittis. Consectetur purus ut faucibus pulvinar.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Eu mi bibendum neque egestas. A diam sollicitudin tempor id eu nisl nunc. Sed lectus vestibulum mattis ullamcorper velit. Sed odio morbi quis commodo. Malesuada fames ac turpis egestas integer eget. Cras ornare arcu dui vivamus. Volutpat ac tincidunt vitae semper quis lectus. Nulla facilisi morbi tempus iaculis. Sem nulla pharetra diam sit amet nisl. Purus ut faucibus pulvinar elementum integer enim. Nisl purus in mollis nunc sed id semper. Eget nulla facilisi etiam dignissim diam quis enim. Sed tempus urna et pharetra pharetra massa massa. A condimentum vitae sapien pellentesque habitant morbi tristique senectus. Habitasse platea dictumst quisque sagittis. Consectetur purus ut faucibus pulvinar."
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
</style>
