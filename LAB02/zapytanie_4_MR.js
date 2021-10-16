db.people.mapReduce(
	function () {
		let key = this.nationality;
		
		let sum = (parseFloat(this.weight) / Math.pow(parseFloat(this.height) / 100, 2));
		let min_BMI = (parseFloat(this.weight) / Math.pow(parseFloat(this.height) / 100, 2));
		let max_BMI = (parseFloat(this.weight) / Math.pow(parseFloat(this.height) / 100, 2));
		
		emit(key, {
			sum,
			min_BMI,
			max_BMI,
			count: 1
		});
	},
	
	function (key, values) {
		var reducedVal = {
			count: 0,
			sum: 0,
			min_BMI: values[0].min_BMI,
			max_BMI: values[0].max_BMI,
		}
	
		values.forEach(function (value) {
			reducedVal.count += value.count;
			reducedVal.sum += value.sum;
			reducedVal.min_BMI = (Math.min(reducedVal.min_BMI, value.min_BMI)).toFixed(2);
			reducedVal.max_BMI = (Math.max(reducedVal.max_BMI, value.max_BMI)).toFixed(2);
		});
	
		return reducedVal;
	},
	
	{
		out: 'bmis',
		finalize: function (key, reducedVal) {
			reducedVal.avg_BMI = (reducedVal.sum / reducedVal.count).toFixed(2);
			delete reducedVal.sum;
			delete reducedVal.count;
			return reducedVal;
		},
	}
);

printjson(db.bmis.find().toArray());