#!/bin/sh

type="$1"
shift
for p in ${1+"$@"}; do
	svn st $p | grep '?' >/dev/null && svn add $p
	mt=$(svn pg svn:mime-type $p)
	if [ X"$mt" != X"$type" ] ; then
		svn ps svn:mime-type "$type" $p
	fi
done
