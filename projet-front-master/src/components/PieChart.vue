<script>
import { Pie } from 'vue-chartjs'

export default {
  extends: Pie,
  props: ["data"],
  mounted () {
    this.renderChart({
          labels: this.data.labels,
          datasets: [
            {
              backgroundColor: this.data.colors,
              data: this.data.values
            }
          ]
        }, { responsive: true, maintainAspectRatio: false })
  }
}

</script>