% Name : Priya Mehta
% Program : Image Recognition

% Specify the folder where the files live.
myFolder = 'C:\Movies, Games, Series\COLLEGE\Priya\testfaces';

% Check to make sure that folder actually exists.  Warn user if it doesn't.
if ~isdir(myFolder)
  errorMessage = sprintf('Error: The following folder does not exist:\n%s', myFolder);
  uiwait(warndlg(errorMessage));
  return;
end

% Get a list of all files in the folder with the desired file name pattern.
% Creating a database of all images with normal expression
filePattern = fullfile(myFolder, '*.normal'); 
theFiles = dir(filePattern);

% Various Declarations
A=[];
coordinate_mat_in=[];
stack_val=[];

%Storing all the faces in an array A
for k = 1 : length(theFiles)
  baseFileName = theFiles(k).name;
  fullFileName = fullfile(myFolder, baseFileName);
  current_img = imread(fullFileName);
  
  % Stacking all the columns to form a vector
  stack_val = current_img(:);
  if k==1
     A = stack_val;
  
  else
      A = [A stack_val];
      
  end
end

% Converting image to double precision
A = im2double(A);

% Performing SVD to get U, sigma and V matrices
[U,S,V] = svd(A, 'econ');

% Getting the rank of A
s = diag(S);
rank_A = nnz(s);

U = single(U);

% Asking for user input
input_name = input('Enter name of image to compare: ', 's');
test_img = imread(input_name);
% Stacking all columns in a vector of the image to test
stack_test = im2double(test_img(:));

dot_product_out=[]; 

% Projecting the test image on the eigen vectors
for k = 1:rank_A
    dot_product_out = [dot_product_out dot(single(U(:,k)), single(stack_test))]
end

dist = [];

% Computing the dot product of the database images with the eigen vectors
for k = 1:rank_A
    dot_product_in=[];
    for j = 1:rank_A
        dot_product_in = [dot_product_in dot(single(U(:,j)), single(A(:,k)))];
    end
    
   % Computing the norm of distance between the test image dot product and
   % the database image dot product
   norm_mat = norm(dot_product_out - dot_product_in);
   
   % Creating an array of distance
   dist = [dist norm_mat];
end

% Getting the index and value of minimum distance to identify the face
% which is nearest to the test face
[val, index] = min(dist);
 
% Displaying the input face and the face in the database nearest to the
% input face
res_img = A(:, index);
res_img = vec2mat(res_img, 243);
res_img = res_img';

subplot(121);imshow(res_img);title('Data Base Image');

subplot(122);imshow(imread(input_name));title('Image Input');


