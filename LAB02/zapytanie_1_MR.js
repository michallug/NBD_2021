db.people.mapReduce(
	function () {
		let key = this.sex;
		let value = {
			height: parseFloat(this.height),
			weight: parseFloat(this.weight),
			count: 1
		};
		emit(key, value);
	},

	function (key, values) {
		let reducedVal = {
			count: 0,
			height: 0,
			weight: 0
		};

		values.forEach(function (value) {
			reducedVal.count += value.count;
			reducedVal.height += value.height;
			reducedVal.weight += value.weight;
		});

		return reducedVal;
	},
	
	{
		out: 'avgs',
		finalize: function (key, reducedVal) {
			reducedVal.height = reducedVal.height / reducedVal.count;
			reducedVal.weight = reducedVal.weight / reducedVal.count;

			return reducedVal;
		},
	}
)

printjson(db.avgs.find().toArray());