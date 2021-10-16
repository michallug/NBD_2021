printjson(
    db.people.mapReduce(
		function() {
			emit(this.job, this.job);
		},
		function(keys, vals) {
			return keys;
		},
		{
			out: { inline: 1 }
		}		
	)
);