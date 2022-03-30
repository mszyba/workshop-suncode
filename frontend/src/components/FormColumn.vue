<template>

  <div class="row justify-content-between">
    <div class="col-4">
      <form id="unique">
        <label>Choose unique: </label>
        <select class="form-select">
          <option value="" >Please select one</option>
          <option
              v-for="(column, index) in columns" :key="index"
              v-bind:value="column.value"> {{column}} </option>
        </select>
      </form>
    </div>

    <div class="col-4">
      <form id="duplicates">
        <label>Choose duplicates: </label>
        <select class="form-select">
          <option selected disabled value="">Please select one</option>
          <option
              v-for="(column, index) in columns" :key="index"
              v-bind:value="column.value"> {{column}} </option>
        </select>
      </form>
    </div>
  </div>

</template>

<script>

import axios from 'axios'

export default {
  name: 'FormColumn',
  mounted: function () {
    this.getColumn()
  },
  data: function () {
    return {
      columns: []
    }
  },
  methods: {
    getColumn: function () {
      let self = this;
      const url = 'http://localhost:8080/api/columns'
      axios.get(url, {
        dataType: 'json',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        mode: 'no-cors',
        credentials: 'include'
      })
          .then(function (response) {
            self.columns = response.data
          })
          .catch(function (error) {
            console.log(error)
          })
    }
  }
}
</script>

<style scoped>
</style>