<!--blanket nav to home|search|login/logout-->

<template>
  <div id="app">
    <nav class="navbar is-pulled-right">
      <router-link class = "navbar-item" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class = "navbar-item" v-bind:to="{ name: 'bands' }">Bands</router-link>
      <router-link class = "navbar-item" v-bind:to="{ name: 'venues' }">Venues</router-link>
      <router-link class = "navbar-item" v-bind:to="{ name: 'shows' }">Shows</router-link>
      <router-link class = "navbar-item" v-bind:to="{ name: 'profile' }">Profile</router-link>
      <!-- if there is no token, it should say Login and disappear once logged in -->
      <router-link class = "navbar-item"
        v-bind:to="{ name: 'login' }"
        v-if="($store.state.token != 'token')"  
        >Login</router-link>

      <!-- if there is a token, it should say Logout and update the token to be removed -->
      <router-link class = "navbar-item"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token == 'token'"
        >Logout</router-link>
    </nav>
    <router-view />
  </div>
</template>
<style>

</style>
