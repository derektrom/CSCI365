-Derek Trom
--derek.trom@und.edu
--A program that asks the user for up to 100 integers sorts the array, gets the average
with Ada.Text_IO; use Ada.Text_IO;
with Ada.Integer_Text_IO; use Ada.Integer_Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
procedure prog6dat is
    type userArray is array(Integer range <>) of Integer;
     NumberArray : userArray(1 .. 100); --creates a numArray called NumberArray of length 100 starting at 1
    array_average: Float;
    array_max: Integer;
    array_min: Integer;
    procedure printIt (NumberArray : in userArray) is
	 i : Integer := 1; --increment variable
	 value : Integer;
	 begin
		 while i <= NumberArray'Length loop 
			 value := NumberArray(i);
			 if value /= -1 then -- -1 means its blank. Don't print it.
			     New_Line(1);
				  Put(value); --print the value
			 end if;
			 i := i + 1; --increment
		 end loop;
	 end printIt;

	 procedure bubble_sort(NumberArray: in out userArray) is 
        i : Integer:= 1;
        temp: Integer;
        j: Integer;
        -- If the inner loop runs with no swaps, exit
        length: Integer:= 1; --counter
        done : Boolean := False; --bool to keep track of when the end is reached
        begin     
        while length <= 100 loop --start with max array can be
	         if NumberArray(length) <= 0 then
		          done := True; --reached the end of user input
	         end if;
            exit when done;
            
            length:= length + 1;--increment
        end loop;
        length := length -1;
            
        while i < length +1  loop
            j := 1;
            --Assume you won't have to make a swap
            while j < length - i + 1 loop
                if NumberArray(j) > NumberArray(j+1) then --swap
                    temp := NumberArray(j);
                    NumberArray(j):= NumberArray(j+1);
                    NumberArray(j+1) := temp;
                end if;
                j := j + 1;
                    
             end loop;
             i:= i + 1;
         end loop; 
     end bubble_sort;
	
    --Create an array with user values
	 function fillArray return userArray is
	     newArray : userArray(1 .. 100); --create an empty userArray
		  i : Integer := 1; --increment variable
		  value : Integer;
		  done : Boolean := False; --boolean variable that is false by default. Set to true if a non-positive integer is entered.	
	     begin
		  Put_Line("Input up to 100 integers (Enter num < 1 to stop): "); --prompt to the user
		  while i <= 100 loop 
		      value := Integer'Value(Get_Line);
			   if value <= 0 then
				    done := True; --the user inputted a non-positive integer, so they are done inputting values.
			   end if;
			   exit when done;
			   newArray(i) := value; 
			   i := i + 1; --increment array
		  end loop;
		  while i <= 100 loop
			   newArray(i) := -1; --fill the rest of the values with -1.
			   i := i + 1;
		  end loop;
		  return newArray;
	 end fillArray;
   
    function average (NumberArray: in userArray) return Float is
       
        sum : Float:= 0.0; --sum var
        counter: Integer:= 1; --counter
        done : Boolean := False; --bool to keep track of when the end is reached
        begin     
        while counter <= 100 loop --start with max array can be
	         if NumberArray(counter) <= 0 then
		      done := True; --reached the end of user input
	     end if;
            exit when done;
            sum := sum + Float(NumberArray(counter));--add num
            counter:= counter + 1;--increment
        end loop;

        return sum/Float(counter-1); --return average
    end average;
    
    function maximum(NumberArray: in userArray) return Integer is 
        max: Integer:= NumberArray(1);
        counter: Integer:= 1; --counter
        done : Boolean := False; --bool to keep track of when the end is reached
        begin
        while counter <= 100 loop --start with max array can be
	         if NumberArray(counter) > max then
                    max := NumberArray(counter);
            end if;
            if NumberArray(counter) <= 0 then
		          done := True; --reached the end of user input
	         end if;
            exit when done;
            counter:= counter + 1;--increment
        end loop;
        return max;
    end maximum;
    function minimum (NumberArray: in userArray) return Integer is 
        min: Integer:= NumberArray(1);
        counter: Integer:= 1; --counter
        done : Boolean := False; --bool to keep track of when the end is reached
        begin
        while counter <= 100 loop --start with max array can be
	         if NumberArray(counter) < min and  not(NumberArray(counter)<0) then
                min := NumberArray(counter);
            end if;
            if NumberArray(counter) <= 0 then
		          done := True; --reached the end of user input
	     end if;
             exit when done;
            counter:= counter + 1;--increment
        end loop;
        return min;
    end minimum;
        
begin

        NumberArray := fillArray;  
        Put("Array Before Sort:");
        printIt(NumberArray); New_Line(1);
        Put("Array After Sorting:");
        bubble_sort(NumberArray);
        printIt(NumberArray); New_Line(1);
        Put("Average of Array: ");
        array_average := average(NumberArray);
        Put(array_average, 1,3,0);
        New_Line(1);
        array_max:= maximum(NumberArray);
        Put("Maximum Value: ");
        Put(Item=>array_max, width => 6);
        New_Line(1); 
        array_min:= minimum(NumberArray);
        Put("Minimum Value: ");
        Put(Item=>array_min, width => 6); 
end prog6dat;