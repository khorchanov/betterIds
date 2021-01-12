# Better Ids

BetterIds is a java library that helps encoding real database ids to an abstract, non-sequential, more compact, String ids that can be used externally (in urls and http requests) and can be decoded internally by the application server to reference the good database entity.

Thanks to this, you will have links like `/users/12543` to `users/Qs2`