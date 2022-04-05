<template>
  <div>
      <h1>Watcher Example</h1>
      <input type="text" v-model="question" />
      <div>Old Value: {{ oldValue }}</div>
      <div>New Value: {{ newValue }}</div>
  </div>
</template>

<script>
export default {
    data() {
        return {
            question: '',
            oldValue: '',
            newValue: ''
        }
    },
    watch: {
        question: function (newValue, oldValue) {
            this.oldValue = oldValue;
            this.newValue = newValue;
        }
    }
}
</script>

<style>

</style>