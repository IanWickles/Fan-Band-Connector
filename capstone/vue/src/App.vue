<!--blanket nav to home|search|login/logout-->

<template>
  <div id="app">
    <div id="nav">
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link> |
      <router-linK v-bind:to="{ name: 'search' }">Search</router-linK> | -->
      <!-- <router-link
        v-bind:to="{ name: 'login' }"
        v-if="($store.state.token = null)"
        >Login</router-link
      > -->
      <!-- <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      > -->
    </div>
    <router-view />
  </div>
</template>
<style></style>
